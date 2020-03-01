;; 레코드

(ns were-records)
(defrecord WereWolf [name title])


(WereWolf. "David" "London Tourist")
; => #were_records.WereWolf{:name "David", :title "London Tourist"}

(->WereWolf "Jacob" "Lead Shirt Discarder")
; => #were_records.WereWolf{:name "Jacob", :title "Lead Shirt Discarder"}

(map->WereWolf {:name "Lucian" :title "CEO of Melodrama"})
; => #were_records.WereWolf{:name "Lucian", :title "CEO of Melodrama"}


(ns monster-mash
    (:import [were_records WereWolf]))
(WereWolf. "David" "London Tourist")
; => #were_records.WereWolf{:name "David", :title "London Tourist"}


(def jacob (->WereWolf "Jacob" "Lead Shirt Discarder"))
(.name jacob)
; => "Jacob"

(:name jacob)
; => "Jacob"

(get jacob :name)
; => "Jacob"


(= jacob (->WereWolf "Jacob" "Lead Shirt Discarder"))
; => true

(= jacob (WereWolf. "David" "London Tourist"))
; => false

(= jacob {:name "Jacob" :title "Lead Shirt Discarder"})
; => false


(assoc jacob :title "Lead Third Wheel")
; => #were_records.WereWolf{:name "Jacob", :title "Lead Third Wheel"}


(dissoc jacob :title)
; => {:name "Jacob"} <- that's not a were_records.WereWolf


(defprotocol WereCreature
  (full-moon-behavior [x]))

(defrecord WereWolf [name title]
  WereCreature
  (full-moon-behavior [x]
    (str name " will howl and murder")))

(full-moon-behavior (map->WereWolf {:name "Lucian" :title "CEO of Melodrama"}))
; => "Lucian will howl and murder"
