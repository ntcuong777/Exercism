(ns interest-is-interesting)

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (cond (< balance 0) -3.213
        (< balance 1000) 0.5
        (and (<= 1000 balance) (< balance 5000)) 1.621
        :else 2.475))

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (* balance (+ 1.0M 
                (/ (bigdec (abs (interest-rate balance))) 
                   100.0M))))

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (int (* (max balance 0) 
          (/ (* tax-free-percentage 2) 
             100))))
