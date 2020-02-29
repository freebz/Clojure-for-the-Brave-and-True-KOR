;; 클로저 형이상학

;; 원자

(def fred (atom {:cuddle-hunger-level 0
                 :percent-deteriorated 0}))


@fred
; => {:cuddle-hunger-level 0, :percent-deteriorated 0}


(let [zombie-state @fred]
  (if (>= (:percent-deteriorated zombie-state) 50)
    (future (println (:percent-deteriorated zombie-state)))))


(swap! fred
       (fn [current-state]
         (merge-with + current-state {:cuddle-hunger-level 1})))
; => {:cuddle-hunger-level 1, :percent-deteriorated 0}


@fred
; => {:cuddle-hunger-level 1, :percent-deteriorated 0}


(swap! fred
       (fn [current-state]
         (merge-with + current-state {:cuddle-hunger-level 1
                                      :percent-deteriorated 1})))
; => {:cuddle-hunger-level 2, :percent-deteriorated 1}


(defn increase-cuddle-hunger-level
  [zombie-state increase-by]
  (merge-with + zombie-state {:cuddle-hunger-level increase-by}))


(increase-cuddle-hunger-level @fred 10)
; => {:cuddle-hunger-level 12, :percent-deteriorated 1}


(swap! fred increase-cuddle-hunger-level 10)
; => {:cuddle-hunger-level 12, :percent-deteriorated 1}

@fred
; => {:cuddle-hunger-level 12, :percent-deteriorated 1}


(update-in {:a {:b 3}} [:a :b] inc)
; => {:a {:b 4}}

(update-in {:a {:b 3}} [:a :b] + 10)
; => {:a {:b 13}}


(swap! fred update-in [:cuddle-hunger-level] + 10)
; => {:cuddle-hunger-level 22, :percent-deteriorated 1}


(let [num (atom 1)
      s1 @num]
  (swap! num inc)
  (println "State 1:" s1)
  (println "Current state:" @num))
; => State 1: 1
; => Current state: 2


(reset! fred {:cuddle-hunger-level 0
              :percent-deteriorated 0})
