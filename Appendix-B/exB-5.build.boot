;; 과업은 미들웨어 공장이다

(defn whiney-middleware-factory
  [rejects]
  {:pre [(set? rejects)]}
  (fn [handler]
    (fn[x]
      (if (= x 1)
        "I'm not going to bother doing anything to that"
        (let [y (handler x)]
          (if rejects y)
          (str "I don't like " y " :'(")
          (str y))))))

(def whiney-strinc ((whiney-middleware-factory #{3}) inc))


(deftask what
  "Specify a thing"
  [t thing     THING str  "An object"
   p pluralize       bool "Whether to pluralize"]
  (fn middleware [next-handler]
    (fn handler [fileset]
      (next-handler (merge fileset {:thing thing :pluralize pluralize})))))

(deftask fire
  "Announce a thing is on fire"
  []
  (fn middleware [next-handler]
    (fn handler [fileset]
      (let [verb (if (:pluralize fileset) "are" "is")]
        (println "My" (:thing fileset) verb "on fire!")
        fileset))))


boot what -t "pants" -p -fire


(boot (what :thing "pants" :pluralize true) (fire))
