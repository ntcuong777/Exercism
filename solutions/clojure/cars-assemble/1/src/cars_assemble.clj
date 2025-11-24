(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [produce-rate (* speed 221)]
    (cond (= speed 0) 0
          (<= 1 speed 4) produce-rate
          (<= 5 speed 8) (* 0.9 produce-rate)
          (= speed 9) (* 0.8 produce-rate)
          :else (* 0.77 produce-rate))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
