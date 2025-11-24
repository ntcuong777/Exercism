(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (first deck))


(defn second-card
  "Returns the second card from deck."
  [deck]
  (second deck))


(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (if (< (count deck) 2)
    deck
    (let [[x1 x2 & rem] deck]
      (into [] (concat [x2 x1] rem)))))


(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [[x & rem] deck]
    (if (= (count rem) 0)
      [x nil]
      [x (into [] rem)])))



(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (if (< (count deck) 1)
    face-cards
    (let [[x & rem] deck]
      (into [] (concat (into [x] face-cards) rem)))))
