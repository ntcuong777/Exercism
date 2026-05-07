let two_fer name =
  let name_or_you = match name with None -> "you" | Some n -> n in
  "One for " ^ name_or_you ^ ", one for me."
