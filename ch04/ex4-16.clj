;; partial

(def add10 (partial + 10))
(add10 3)
; => 13

(add10 5)
; => 15

(def add-mmissing-elements
  (partial conj ["water" "earth" "air"]))

(add-mmissing-elements "unobtainium" "adamantium")
; => ["water" "earth" "air" "unobtainium" "adamantium"]


(defn my-partial
  [partialized-fn & args]
  (fn [& more-args]
    (apply partialized-fn (into args more-args))))

(def add20 (my-partial + 20))
(add20 3)
; => 23


(fn [& more-args]
  (apply + (into [20] more-args)))


(defn lousy-logger
  [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)))

(def warn (partial lousy-logger :warn))

(warn "Red light ahead")
; => "red light ahead"
