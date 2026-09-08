# ULID Sample - Java

A small Java project created to understand **ULID (Universally Unique Lexicographically Sortable Identifier)** and its time-sortable nature.

The project demonstrates:

- Generating ULIDs in Java
- Understanding the structure of a ULID
- Generating multiple ULIDs
- Shuffling ULIDs
- Sorting ULIDs using normal String sorting
- Observing how lexicographical sorting preserves chronological order


---

## What is ULID?

**ULID** stands for:

> Universally Unique Lexicographically Sortable Identifier

A ULID is a 128-bit identifier consisting of:

```text
┌──────────────────────┬───────────────────────────────┐
│      Timestamp       │          Randomness           │
│       48 bits        │            80 bits            │
└──────────────────────┴───────────────────────────────┘
```

A typical ULID looks like:

```text
01M20T1NT28QHEX86XBJ3CBZ3P

┌──────────┬────────────────┐
│Timestamp │   Randomness   │
│ 10 chars │    16 chars    │
└──────────┴────────────────┘
```

The timestamp is placed at the beginning of the identifier.

```text
01M20T1NT2 | 8QHEX86XBJ3CBZ3P
^^^^^^^^^^   ^^^^^^^^^^^^^^^^
timestamp     randomness
 10 chars       16 chars
```


Because of this structure, ULIDs can be sorted lexicographically and still maintain chronological ordering.

## Experiment

The main experiment of this project is 

```text
Generate ULIDs
      ↓
Shuffle ULIDs
      ↓
Sort ULIDs
      ↓
Observe chronological ordering
```
The project intentionally adds a small delay between ULID generations so that the timestamp difference is easier to observe while experimenting.

The delay is only for demonstration purposes and is not required when generating ULIDs in a real application.

## What I Learned

This experiment helped me understand that ULID is not simply "another UUID".

The important idea is the combination of:

```text
Uniqueness
    +
Timestamp
    +
Lexicographical ordering
```

The fact that a ULID can be sorted as a normal String while preserving chronological ordering is particularly useful for understanding why time-sortable identifiers can be valuable in distributed systems.

## Further Reading

- ULID specification: https://github.com/ulid/spec
- ULID Creator: https://github.com/f4b6a3/ulid-creator