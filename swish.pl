% State NOtation: state(Missionares Left, Cannibals Left, Boat Loction) Note that the Right side values can be 
% computed as Cannibals Right = 3 - Cannibals Left and Missionaries = 3 - Missionaries Left.

% Initial state
initial_state(state(3, 3, left)).	% 3 Missionaries and 3 Cannibals at Left side. 

% Final state
final_state(state(0, 0, right)).	% 3 Missionaries and 3 Cannibals at RIght side.

% Valid state
valid_state(state(M, C, _)) :-		% Determine if the current state is valid
    M >= 0, C >= 0, M =< 3, C =< 3,	% The number of canniblas and missionaries is one of {0,1,2,3}
    (M >= C ; M = 0),				% The # of left cannibals is less than the # of left missionaries or there are no miss. at left
    (3 - M >= 3 - C ; M = 3).		% The # of right cannibals is less than the # of roght missinaries or there are no miss. at right 

% Movements move{code}(original_state)
% {code} = {# miss to move from left} {# cann to move from left} {# miss to move from right} {# cann to move from right}

% Move -> 1 miss.
move1000(state(M1, C1, left)) :-
    M2 is M1 - 1,
    valid_state(state(M2, C1, right)).

% Move -> 1 cann.
move0100(state(M1, C1, left)) :-
    C2 is C1 - 1,
    valid_state(state(M1, C2, right)).

% Move -> 1 miss. & 1 cann.
move1100(state(M1, C1, left)) :-
    M2 is M1 - 1,
    C2 is C1 - 1,
    valid_state(state(M2, C2, right)).

% Move -> 2 miss.
move2000(state(M1, C1, left)) :-
    M2 is M1 - 2,
    valid_state(state(M2, C1, right)).

% Move -> 2 cann.
move0200(state(M1, C1, left)) :-
    C2 is C1 - 2,
    valid_state(state(M1, C2, right)).


% Move <- 1 cann.
move0001(state(M1, C1, right)) :-
    C2 is C1 + 1,
    valid_state(state(M1, C2, left)).

% Move <- 1 miss.
move0010(state(M1, C1, right)) :-
    M2 is M1 + 1,
    valid_state(state(M2, C1, left)).

% Move <- 1 miss. & 1 cann.
move0011(state(M1, C1, right)) :-
    M2 is M1 + 1,
    C2 is C1 + 1,
    valid_state(state(M2, C2, left)).

% Move <- 2 cann.
move0002(state(M1, C1, right)) :-
    C2 is C1 + 2,
    valid_state(state(M1, C2, left)).


% Move <- 2 miss.
move0020(state(M1, C1, right)) :-
    M2 is M1 + 2,
    valid_state(state(M2, C1, left)).




    