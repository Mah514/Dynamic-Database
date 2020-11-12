# CVR
a Vehicle Identification Number 'VIN' is unique to each vehicle and is restricted in length to 17 alphanumeric characters.
Each VIN is linked to relevant information and history for a specific vehicle.

CVR is data structure for VINs that adapts to its usage and keeps the balance between memory and runtime requirements.
This is a customized data structure which automatically adapts to the dynamic content that it operates on. 
In other words, it accepts the size(totla number of Vehicle Identification Numbers) as a parameter and uses an appropriate set of data structures:
If the number of stored Value/Key pairs exceeds a certain threshold (set by the user), CVR uses a Sequence ADT that use less memory overhead but slower (sorting)
algorithms. On the other hand, if the number of contained entries is large (tens of thousands of elements or more), CVR adapts to a hashtable ADT which has a 
higher memory requirement but faster (sorting) algorithms.
