;; 파일과 입/출력

(let [file (java.io.File. "/")]
  (println (.exists file))
  (println (.canWrite file))
  (println (.getPath file)))
; => true
; => false
; => /


(spit "/tmp/hercules-todo-list"
"- kill dat lion brov
- chop up what nasty multi-headed snake thing")

(slurp "/tmp/hercules-todo-list")

; => "- kill dat lion brov
;     - chop up what nasty multi-headed snake thing"


(let [s (java.io.StringWriter.)]
  (spit s "- capture cerynian hind like for real")
  (.toString s))
; => "- capture cerynian hind like for real"


(let [s (java.io.StringReader. "- get erymanthian pig what with the tusks")]
  (slurp s))
; => "- get erymanthian pig what with the tusks"


(with-open [todo-list-rdr (clojure.java.io/reader "/tmp/hercules-todo-list")]
  (println (first (line-seq todo-list-rdr))))
; => - kill dat lion brov
