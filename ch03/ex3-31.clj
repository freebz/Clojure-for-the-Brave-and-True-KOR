;; reduce로 균형을 맞추는 방법

;; reduce로 합계 구하기
(reduce + [1 2 3 4])
; => 10


(+ (+ ( + 1 2) 3) 4)


(reduce + 15 [1 2 3 4])


(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))


(defn better-symmetrize-body-parts
  ":name과 :size 대응관계를 갖는 배열을 기대함"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))
