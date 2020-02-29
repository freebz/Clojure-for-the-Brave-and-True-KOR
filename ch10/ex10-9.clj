;; 스레드 별 결합

(.write *out* "prints to repl")
; => prints to repl


(.start (Thread. #(.write *out* "prints to standard out")))


(let [out *out*]
  (.start
   (Thread. #(binding [*out* out]
               (.write *out* "prints to repl from thread")))))


(.start (Thread. (bound-fn [] (.write *out* "prints to repl from thread"))))
