;; 가져오기

(import java.util.Stack)
(Stack.)
; => []


(import [java.util Date Stack]
        [java.net Proxy URI])

(Date.)
; => #inst "2016-09-19T20:40:02.733-00:00"


(ns pirate.talk
  (:import [java.util Date Stack]
           [java.net Proxy URI]))
