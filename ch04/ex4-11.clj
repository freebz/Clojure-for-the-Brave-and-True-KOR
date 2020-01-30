;; 무한 배열

(concat (take 8 (repeat "na")) ["Batman!"])
; => ("na" "na" "na" "na" "na" "na" "na" "na" "Batman!")


(take 3 (repeatedly (fn [] (rand-int 10))))
; => (1 4 0)


(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))
; => (0 2 4 6 8 10 12 14 16 18)
