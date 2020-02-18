;; 구문 인용

'+
; => +


'clojure.core/+
; => clojure.core/+


`+
; => clojure.core/+


'(+ 1 2)
; => (+ 1 2)


`(+ 1 2)
; => (clojure.core/+ 1 2)


`(+ 1 ~(inc 1))
; => (clojure.core/+ 1 2)


`(+ 1 (inc 1))
; => (clojure.core/+ 1 (clojure.core/inc 1))


(list '+ 1 (inc 1))
; => (+ 1 2)

`(+ 1 ~(inc 1))
; => (clojure.core/+ 1 2)
