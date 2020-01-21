(def severity :mild)
(def error_message "OH GOD! IT'S A DISASTER! WE'RE ")
(if (= severity :mild)
  (def error_message (str error_message "MILDLY INCONVENIENCED!"))
  (def error_message (str error_message "DOOOOOOOMED!")))


(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))

(error-message :mild)
; => "OH GOD! IT'S A DISASTER! WE'RE MILDLY INCONVENIENCED!"
