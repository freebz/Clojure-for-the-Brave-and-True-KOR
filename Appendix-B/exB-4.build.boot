;; 핸들러와 미들웨어

(def strinc (comp str inc))
(strinc 3)
; => "4"


(defn whiney-str
  [rejects]
  {:pre [(set? rejects)]}
  (fn [x]
    (if (rejects x)
      (str "I don't like " x)
      (str x))))

(def whiney-strinc (comp (whiney-str #{2}) inc))
(whiney-strinc 1)
; => "I don't like 2"


(defn whiney-middleware
  [next-handler rejects]
  {:pre [(set? rejects)]}
  (fn [x]
    (if (= x 1)
      "I'm not going to bother doing anything to that"
      (let [y (next-handler x)]
        (if (rejects y)
          (str "I don't like " y)
          (str y))))))

(def whiney-strinc (whiney-middleware inc #{2}))
(whiney-strinc 1)
; => "I don't like 2"
