(ns collatz-conjecture)

(defn collatz
  "Returns the number of steps for num to reach 1
  according to the Collatz Conjecture."
  [num]
  (letfn [(cnt-fn [n cnt]
                  (cond
                    (= n 1) cnt
                    (= (mod n 2) 0) (recur (/ n 2) (+ cnt 1))
                    :else (recur (+ 1 (* n 3)) (+ cnt 1))))]
    (cnt-fn num 0))
)
