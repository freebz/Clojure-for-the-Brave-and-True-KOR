;; 매크로는 중요하다

(when boolean-expression
  expression-1
  expression-2
  expression-3
  ...
  expression-x)


(macroexpand '(when boolean-expression
                expression-1
                expression-2
                expression-3))
; => (if boolean-expression
;      (do expression-1
;          expression-2
;          expression-3))
