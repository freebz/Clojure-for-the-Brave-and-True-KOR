;; 함수의 호출

(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])


(or + -)
; => #function[clojure.core/+]


((or + -) 1 2 3)
; => 6


((and (= 1 1) +) 1 2 3)
; => 6

((first [+ 0]) 1 2 3)
; => 6


(1 2 3 4)
("test" 1 2 3)


; ClassCastException: java.lang.String cannot be cast to clojure.lang.IFn


(inc 1.1)
; => 2.1

(map inc [0 1 2 3])
; => (1 2 3 4)


(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2))) ; "(inc 199)"를 계산한 결과
(+ 200 (/ 100 5)) ; (- 7 2)를 계산한 결과
(+ 200 20) ; (/ 100 5)를 계산한 결과
220 ; 최종 계산 결과
