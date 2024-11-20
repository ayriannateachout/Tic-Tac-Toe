/*
 * Programmer:Ayrianna Teachout
 * Date:11/12/23
 * Purpose:Extends person class with additional attributes
 */

class Player extends Person {
    int skillLevel;
    int numMoves;
    int numTimesPlayed;

    public Player(String name, int skillLevel) {
        super(name);
        this.skillLevel = skillLevel;
        this.numMoves = 0;
        this.numTimesPlayed = 0;
    }
}