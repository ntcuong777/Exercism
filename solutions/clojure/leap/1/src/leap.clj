(ns leap)

(defn leap-year?
  "Returns true if the given year is a leap year;
  otherwise, it returns false."
  [year]
  (if (= (mod year 100) 0)
    (= (mod year 400) 0)
    (= (mod year 4) 0))
  )
