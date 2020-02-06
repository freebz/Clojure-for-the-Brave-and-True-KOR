;; 변하지 않는 자료 구조 이용하기

;; for/while을 대신하는 반복

(def great-baby-name "Rosanthony")
great-baby-name
; => "Rosanthony"

(let [great-baby-name "Bloodthunder"]
  great-baby-name)
; => "Bloodthunder"

great-baby-name
; => "Rosanthony"


(defn sum
  ([vals] (sum vals 0))
  ([vals accumulating-total]
      (if (empty? vals)
        accumulating-total
        (sum (rest vals) (+ (first vals) accumulating-total)))))


(sum [30 5 1]) ; 인자가 한 개인 함수가 두 개를 쓰는 함수를 호출한다.
(sum [39 5 1] 0)
(sum [5 1] 39)
(sum [1] 44)
(sum [] 45) ; 기본 조건을 충족하면 accumulating-total을 반환한다.
; => 45


(defn sum
  ([vals]
     (sum vals 0))
  ([vals accumulating-total]
     (if (empty? vals)
       accumulating-total
       (recur (rest vals) (+ (first vals) accumulating-total)))))
