;; 미래

(future (Thread/sleep 4000)
        (println "I'll print after 4 seconds"))
(println "I'll print immediately")


(let [result (future (println "this prints once")
                     (+ 1 1))]
  (println "deref: " (deref result))
  (println "@: " @result))
; => this prints once
; => deref:  2
; => @:  2


(let [result (future (Thread/sleep 3000)
                     (+ 1 1))]
  (println "The result is: " @result)
  (println "It will be at least 3 seconds before I print"))
; => The result is:  2
; => It will be at least 3 seconds before I print


(deref (future (Thread/sleep 1000) 0) 10 5)
; => 5


(realized? (future (Thread/sleep 1000)))
; => false

(let [f (future)]
  @f
  (realized? f))
; => true
