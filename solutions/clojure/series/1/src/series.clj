(ns series)

(defn slices
  "Returns all contiguous substrings of length n from the string s."
  [s n]
  (cond 
    (= (count s) 0)
    (throw (IllegalArgumentException. "series cannot be empty"))
    
    (> n (count s))
    (throw (IllegalArgumentException. "slice length cannot be greater than series length"))

    (= n 0)
    (throw (IllegalArgumentException. "slice length cannot be zero"))

    (< n 0)
    (throw (IllegalArgumentException. "slice length cannot be negative"))

    :else
    (let [svec (vec s)
          len-s (count s)]
      (map (fn [i]
             (apply str (subvec svec i (+ i n))))
           (range 0
                  (+ 1 (- len-s n))))))
  )
