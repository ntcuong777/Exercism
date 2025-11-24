let raindrop n =
  let rec raindrop_helper n c =
    if n mod 3 = 0 && c = 0 then
      "Pling" ^ raindrop_helper (n / 3) 1
    else if n mod 5 = 0 && c < 2 then
      "Plang" ^ raindrop_helper (n / 5) 2
    else if n mod 7 = 0 && c < 3 then
      "Plong" ^ raindrop_helper (n / 7) 3
    else if c = 0 then
      string_of_int n
    else
      ""
  in
  raindrop_helper n 0
