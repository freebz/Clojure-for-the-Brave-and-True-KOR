;; 리더 매크로

(read-string "'(a b c)")
; => (quote (a b c))


(read-string "@var")
; => (clojure.core/deref var)


(read-string "; ignore!\n(+ 1 2)")
; => (+ 1 2)
