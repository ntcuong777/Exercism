let validate candidate =
  let candidate_len = String.length (string_of_int candidate) in
  let rec pow x n =
    if n = 0 then 1
    else x * pow x (n - 1)
  in
  let rec sum_of_digits acc n =
    if n = 0 then acc
    else sum_of_digits (acc + pow (n mod 10) candidate_len) (n / 10)
  in
  candidate = sum_of_digits 0 candidate
