;; 리더

;; 읽기

(str "To understand what recursion is," " you must first understand recursion.")
; => "To understand what recursion is, you must first understand recursion."


(read-string "(+ 1 2)")
; => (+ 1 2)

(list? (read-string "(+ 1 2)"))
; => true

(conj (read-string "(+ 1 2)") :zagglewag)
; => (:zagglewag + 1 2)


(eval (read-string "(+ 1 2)"))
; => 3


(#(+ 1 %) 3)
; => 4

(read-string "#(+ 1 %)")
; => (fn* [p1__423#] (+ 1 p1__423#))
