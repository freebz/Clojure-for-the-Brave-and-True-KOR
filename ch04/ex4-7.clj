;; filter, some

(filter #(< (:human %) 5) food-journal)
; => ({:month 2, :day 1, :human 4.9, :critter 2.1}
;     {:month 3, :day 1, :human 4.2, :critter 3.3}
;     {:month 3, :day 2, :human 4.0, :critter 3.8}
;     {:month 4, :day 1, :human 3.7, :critter 3.9}
;     {:month 4, :day 2, :human 3.7, :critter 3.6})


(filter #(< (:month %) 3) food-journal)
; => ({:month 1, :day 1, :human 5.3, :critter 2.3}
;     {:month 1, :day 2, :human 5.1, :critter 2.0}
;     {:month 2, :day 1, :human 4.9, :critter 2.1}
;     {:month 2, :day 2, :human 5.0, :critter 2.5})


(some #(> (:critter %) 5) food-journal)
; => nil

(some #(> (:critter %) 3) food-journal)
; => true


(some #(and (> (:critter %) 3) %) food-journal)
; => {:month 3, :day 1, :human 4.2, :critter 3.3}
