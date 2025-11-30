(ns eliuds-eggs)

(defn egg-count
  "Returns the number of 1 bits in the binary representation of the given number."
  [num]
  (if (<= num 1)
    num
    (let [eggs-in-coop (mod num 2)]
      (+ eggs-in-coop (egg-count (int (/ num 2))))))
  )
