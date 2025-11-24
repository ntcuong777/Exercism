(ns knapsack)

(defn maximum-value
  "Calculates the maximum value that can be packed.
  Items shape: [{:weight: weight, :value: value}]"
  [maximum-weight items]
  (let [dp (vec (repeat (+ maximum-weight 1) 0))]
    (apply max (reduce (fn calc-fn
                         ([] dp)
                         ([dp] dp)
                         ([dp item]
                          (reduce (fn [dp' w]
                                    (if (>= w (:weight item))
                                      (assoc dp' w
                                             (max (dp' w)
                                                  (+ (dp' (- w (:weight item)))
                                                     (:value item))))
                                      dp'))
                                  dp
                                  (range maximum-weight -1 -1))))
                       dp
                       items))))
