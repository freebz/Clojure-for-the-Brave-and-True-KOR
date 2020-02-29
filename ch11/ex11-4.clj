;; 스레드

(thread (println (<!! echo-chan)))
(>!! echo-chan "mustard")
; => true
; => mustard


(let [t (thread "chili")]
  (<!! t))
; => "chili"
