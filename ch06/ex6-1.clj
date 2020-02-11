;; 프로젝트를 도서관처럼

(ns-name *ns*)
; => user


inc
; => #function[clojure.core/inc]

'inc
; => inc

(map inc [1 2])
; => (2 3)

'(map inc [1 2])
; => (map inc [1 2])
