(ns fwpd.core)
(def filename "suspects.csv")


(slurp filename)
; => "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6"


(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))


(convert :glitter-index "3")
; => 3


(defn parse
    "Convert a CSV into rows of columns"
    [string]
    (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))


(parse (slurp filename))
; => (["Edward Cullen" "10"] ["Bella Swan" "0"] ["Charlie Swan" "0"]
;     ["Jacob Black" "3"] ["Carlisle Cullen" "6"])


(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))


(first (mapify (parse (slurp filename))))
; => {:name "Edward Cullen", :glitter-index 10}


(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))


(glitter-filter 3 (mapify (parse (slurp filename))))
;({:name "Edward Cullen", :glitter-index 10}
; {:name "Jacob Black", :glitter-index 3}
; {:name "Carlisle Cullen", :glitter-index 6})
