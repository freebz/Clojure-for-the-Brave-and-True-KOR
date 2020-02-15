;; 매크로

(read-string "(1 + 1)")
; => (1 + 1)


(eval (read-string "(1 + 1)"))
; => ClassCastException: java.lang.Long cannot be cast to clojure.lang.IFn


(let [infix (read-string "(1 + 1)")]
  (list (second infix) (first infix) (last infix)))
; => (+ 1 1)


(eval
 (let [infix (read-string "(1 + 1)")]
   (list (second infix) (first infix) (last infix))))
; => 2


(defmacro ignore-last-operand
  [function-call]
  (butlast function-call))

(ignore-last-operand (+ 1 2 10))
; => 3

;; This will not print anything
(ignore-last-operand (+ 1 2 (println "look at me!!!")))
; => 3


(macroexpand '(ignore-last-operand (+ 1 2 10)))
; => (+ 1 2)

(macroexpand '(ignore-last-operand (+ 1 2 (println "look at me!!!"))))
; => (+ 1 2)


(defmacro infix
  [infixed]
  (list (second infixed)
        (first infixed)
        (last infixed)))

(infix (1 + 2))
; => 3
