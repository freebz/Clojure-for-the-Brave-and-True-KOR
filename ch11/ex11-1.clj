;; 프로세스로 시작하기

[[org.clojure/clojure "1.7.0"]
[org.clojure/core.async "0.1.346.0-17112a-alpha"]]


(ns playsync.core
  (:require [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]))


(def echo-chan (chan))
(go (println (<! echo-chan)))
(>!! echo-chan "ketchup")
; => true
; => ketchup


(>!! (chan) "mustard")
