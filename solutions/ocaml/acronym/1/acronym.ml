let take_first_alphabet_char s =
  let rec aux i =
    if i >= String.length s then None
    else if Char.Ascii.is_letter s.[i] then Some (Char.uppercase_ascii s.[i])
    else aux (i + 1)
  in
  aux 0

let acronym phrase =
  let words =
    phrase |> String.split_on_char ' '
    |> List.map (fun w -> String.split_on_char '-' w)
    |> List.flatten
    |> List.filter (fun w -> w <> "")
    |> List.map (fun w -> take_first_alphabet_char w)
  in
  let acronym_chars =
    words
    |> List.filter_map (fun x -> match x with Some c -> Some c | None -> None)
    |> List.map (String.make 1)
    |> String.concat ""
  in
  acronym_chars
