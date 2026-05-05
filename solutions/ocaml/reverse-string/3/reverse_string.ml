let reverse_string s =
  let rec rev acc xs =
    match xs with
    | [] -> acc
    | x :: xs -> rev (List.append [ x ] acc) xs
  in
  (rev [] (s |> String.to_seq |> List.of_seq)) |> List.to_seq |> String.of_seq
