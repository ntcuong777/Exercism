(ns card-games)

(defn rounds
  "Takes the current round number and returns
   a `list` with that round and the _next two_."
  [n]
  (list n (inc n) (+ n 2)))


(defn concat-rounds
  "Takes two lists and returns a single `list`
   consisting of all the rounds in the first `list`,
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))


(defn contains-round?
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some #(= % n) l)))


(defn card-average
  "Returns the average value of a hand"
  [hand]
  (/ (reduce + 0.0 hand) (count hand)))


(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [avg (card-average hand)]
    (or (= avg
           (card-average (list (first hand)
                               (last hand))))
        (== avg
           (nth hand (int (/ (count hand) 2)))))))


(defn average-even-odd?
  "Returns true if the average of the cards at even indexes
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [sum-even (reduce + (map #(nth hand %) (range 0 (count hand) 2)))
        sum-odd (reduce + (map #(nth hand %) (range 1 (count hand) 2)))
        num-odd (max 1 (int (/ (count hand) 2)))
        num-even (max 1 (- (count hand) num-odd))]
    (= (/ sum-even num-even) (/ sum-odd num-odd))))


(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (and (>= (count hand) 1)
           (= (last hand) 11))
    (reverse (cons 22 (map #(nth hand %)
                           (range (- (count hand)
                                     2)
                                  -1
                                  -1))))
    hand))
