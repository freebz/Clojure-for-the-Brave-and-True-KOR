;; if-valid

(let [errors (validate order-details order-details-validations)]
  (if (empty? errors)
    (println :success)
    (println :failure errors)))


(defn if-valid
  [record validations success-code failure-code]
  (let [errors (validate record validations)]
    (if (empty? errors)
      success-code
      failure-code)))


(if-valid order-details order-details-validations errors
 (println :success)
 (println :failure errors))


(defmacro if-valid
  "Handle validaton more concisely"
  [to-validate validations errors-name & then-else]
  `(let [~errors-name (validate ~to-validate ~validations)]
     (if (empty? ~errors-name)
       ~@then-else)))


(macroexpand
 '(if-valid order-details order-details-validations my-error-name
            (println :success)
            (println :failure my-error-name)))
(let*
  [my-error-name (user/validate order-details order-details-validations)]
  (if (clojure.core/empty? my-error-name)
    (println :success)
    (println :failure my-error-name)))
