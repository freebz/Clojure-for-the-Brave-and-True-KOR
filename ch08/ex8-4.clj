;; 단순 인용

(+ 1 2)
; => 3


(quote (+ 1 2))
; => (+ 1 2)


+
; => #function[clojure.core/+]


(quote +)
; => +


sweating-to-the-oldies
; => Unable to resolve symbol: sweating-to-the-oldies in this context


(quote sweating-to-the-oldies)
; => sweating-to-the-oldies


'(+ 1 2)
; => (+ 1 2)

'dr-jekyll-and-richard-simmons
; => dr-jekyll-and-richard-simmons


(defmacro when
  "Evaluates test. If logical true, evaluates body in an implicit do."
  {:added "1.0"}
  [test & body]
  (list 'if test (cons 'do body)))


(macroexpand '(when (the-cows-come :home)
                (call me :pappy)
                (slap me :silly)))
; => (if (the-cows-come :home)
;      (do (call me :pappy)
;          (slap me :silly)))


(defmacro unless
  "Inverted 'if'"
  [test & branches]
  (conj (reverse branches) test 'if))


(macroexpand '(unless (done-been slapped? me)
                      (slap me :silly)
                      (say "I reckon that'll learn me")))
; => (if (done-been slapped? me)
;      (say "I reckon that'll learn me")
;      (slap me :silly))
