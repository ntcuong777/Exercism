let rec egg_count number =
  if number == 0 then
    0
  else if number == 1 then
    1
  else
  let last_bit = number mod 2 in
    last_bit + egg_count (number / 2)
