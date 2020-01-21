;; 매개 변수와 그 숫자

(defn no-params
  []
  "I take no parameters!")
(defn one-param
  [x]
  (str "I take one parameter: " x))
(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smooth them "
       "together to spite you! " x y))


(defn multi-arity
  ;; 3개의 인자와 함수 몸체
  ([first-arg second-arg third-arg]
     (do-things first-arg second-arg third-arg))
  ;; 2개의 인자와 함수 몸체
  ([first-arg second-arg]
     (do-things first-arg second-arg))
  ;; 1개의 인자와 함수 몸체
  ([first-arg]
     (do-things first-arg)))


(defn x-chop
  "상대를 가격할 때 손으로 내려치는 종류를 기술함."
  ([name chop-type]
    (str "I " chop-type " chop " name "! Take that!"))
  ([name]
    (x-chop name "karate")))


(x-chop "Kanye West" "slap")
; => "I slap chop Kanye West! Take that!"


(x-chop "Kanye East")
; => "I karate chop Kanye East! Take that!"


(defn weird-arity
  ([]
     "Destiny dressed you this morning, my friend, and now Fear is
     trying to pull off your pants. If you give up, if you give in,
     you're gonna end up naked with Fear just standing there
     laughing at your dangling unmentionables! - the Tick")
  ([number]
     (inc number)))


(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")
; => ("Get off my lawn, Billy!!!"
;     "Get off my lawn, Anne-Marie!!!"
;     "Get off my lawn, The Incredible Bulk!!!")


(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")
; => "Hi, Doreen, here are my favorite things: gum, shoes, kara-te"
