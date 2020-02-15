;; 구문 추상화, 그리고 -> 매크로

(defn read-resource
  "Read a resource into a string"
  [path]
  (read-string (slurp (clojure.java.io/resource path))))


(defn read-resource
  [path]
  (-> path
      clojure.java.io/resource
      slurp
      read-string))
