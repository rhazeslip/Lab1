Using the strategy and observer pattern:
For the Strategy pattern I had to create an additional interface named ChangeCalculations 
  and an additional class named GreedyChange, along with some changes to the register class.

Strategy Pattern:
- Can now easily add alternative calculations for the change.
- Calculation method can be changed at runtime.
- Better separation

Observer Pattern:
- The Register no longer need to Control the UI components
- Has multiple views to observe the same register
- Reduced coupling between components
