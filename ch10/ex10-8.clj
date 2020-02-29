;; 동적 변수의 활용

(defn notify
  [message]
  (str "TO: " *notification-address* "\n"
       "MESSAGE: " message))
(notify "I fell.")
; => "TO: dobby@elf.org\nMESSAGE: I fell."


(binding [*notification-address* "test@elf.org"]
  (notify "test!"))
; => "TO: test@elf.org\nMESSAGE: test!"


(binding [*out* (clojure.java.io/writer "print-output")]
  (println "A man who carries a cat by the tail learns
something he can learn in no other way.
-- Mark Twain"))
(slurp "print-output")
; => A man who carries a cat by the tail learns
;    something he can learn in no other way.
;    -- Mark Twain


(println ["Print" "all" "the" "things!"])
; => [Print all the things!]

(binding [*print-length* 1]
  (println ["Print" "just" "one!"]))
; => [Print ...]


(def ^:dynamic *troll-thought* nil)
(defn troll-riddle
  [your-answer]
  (let [number "man meat"]
    (when (thread-bound? #'*troll-thought*)
      (set! *troll-thought* number))
    (if (= number your-answer)
      "TROLL: You can cross the bridge!"
      "TROLL: Time to eat you, succulent human!")))

(binding [*troll-thought* nil]
  (println (troll-riddle 2))
  (println "SUCCULENT HUMAN: Oooooh! The answer was" *troll-thought*))

; => TROLL: Time to eat you, succulent human!
; => SUCCULENT HUMAN: Oooooh! The answer was man meat


*troll-thought*
; => nil
