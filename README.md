# SNAKE-FLAPPY
Snake + path finding , "flappy bird" + neuron network


Snake Key_bind \

WASD \


Flappy \

UP arrow \


Snake AI use path finding  \

short description of the algorithm  \


we start whit 2-d array  \
 0 == skane head  (dist(head,head)=0) \
-1 == snake body \
-3 == food \
-4 == not checked but empty box  \

generally if value < 0  => special value / unavailable box \

we start from the head and \
all empty adjacent fields are overwritten with 1 \

if some box has been changed, it is saved for use in the next iteration (becouse now we had to check all adjacent box) \

now we have list of box "to check" \

for each box we do exactly the same we check if the value of the neighbor is greater than x +1, \
if this is true we change the value and add box to the list "to check" \
if false we do nothing \

we keep doing this until we find food then we stop . \
we create "patch list" \
and we start from food we add (x_0,y_0) for food box to the list \
then we find lowest adjacent value box and add(x_1,y_1) to the list \
we keep doing this until we find box valuse == 0 then we stop . \

at this point we have a list of coordinates from food to snake head \

this is the shortest way, it is because we always chose the box with the lowest value \

now all you have to do is follow the list (but reversed) \

the algorithm does not predict tail movement so it will not work if there is no path to food \
(program still work just if "to chekc" is empty and we still didn't find food we stop the algorithm and try again in next frame) \





Flappy AI neuron network\
