package org.pokemon;

import org.zengine.uils.Random;

/**
 * 
 * @author NerdyGnome
 *
 */
public class PokemonMonster {
	private short id; 
	private String name;
	private char gender;
	private short[] type;
	private short hp;
	private short attack;
	private short defense;
	private short spAttack;
	private short spDefense;
	private short speed;
	private short statTotal;
	private double chanceOfBeingMale;
	private short captureRate;
	private short exp;
	private short[] startingMoves;
	private short[] possibleMoves;
	private short[] moveLevels;
	private short[] evolvesInto;
	private short[] evolveLevels;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param type
	 * @param hp
	 * @param attack
	 * @param defense
	 * @param spAttack
	 * @param spDefense
	 * @param speed
	 * @param statTotal
	 * @param chanceOfBeingMale
	 * @param captureRate
	 * @param exp
	 * @param startingMoves
	 * @param possibleMoves
	 * @param moveLevels
	 * @param evolvesInto
	 * @param evolveLevels
	 */
	public PokemonMonster(short id, String name, short[] type, short hp, short attack, short defense, short spAttack, 
	short spDefense, short speed, short statTotal, double chanceOfBeingMale, short captureRate, short exp,
	short[] startingMoves, short[] possibleMoves, short[] moveLevels, short[] evolvesInto, short[] evolveLevels) {
			
		this.id = id;
		this.name = name;
		this.gender = createGender(chanceOfBeingMale);
		this.type = type;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.statTotal = statTotal;
		this.chanceOfBeingMale = chanceOfBeingMale;
		this.captureRate = captureRate;
		this.exp = exp;
		this.startingMoves = startingMoves;
		this.possibleMoves = possibleMoves;
		this.moveLevels = moveLevels;
		this.evolvesInto = evolvesInto;
		this.evolveLevels = evolveLevels;		
	}
	
	private char createGender(double chanceOfMale) {		
		double randomValue = 0;
		Random r = new Random();
		
		try {
			randomValue = r.random(0, 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(randomValue < chanceOfMale)
			return 'M';
		else
			return 'F';	
	}
		
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public short[] getType() {
		return type;
	}

	public void setType(short[] type) {
		this.type = type;
	}

	public short getHp() {
		return hp;
	}

	public void setHp(short hp) {
		this.hp = hp;
	}

	public short getAttack() {
		return attack;
	}

	public void setAttack(short attack) {
		this.attack = attack;
	}

	public short getDefense() {
		return defense;
	}

	public void setDefense(short defense) {
		this.defense = defense;
	}

	public short getSpAttack() {
		return spAttack;
	}

	public void setSpAttack(short spAttack) {
		this.spAttack = spAttack;
	}

	public short getSpDefense() {
		return spDefense;
	}

	public void setSpDefense(short spDefense) {
		this.spDefense = spDefense;
	}

	public short getSpeed() {
		return speed;
	}

	public void setSpeed(short speed) {
		this.speed = speed;
	}

	public short getStatTotal() {
		return statTotal;
	}

	public void setStatTotal(short statTotal) {
		this.statTotal = statTotal;
	}

	public double getChanceOfBeingMale() {
		return chanceOfBeingMale;
	}

	public void setChanceOfBeingMale(double chanceOfBeingMale) {
		this.chanceOfBeingMale = chanceOfBeingMale;
	}

	public short getCaptureRate() {
		return captureRate;
	}

	public void setCaptureRate(short captureRate) {
		this.captureRate = captureRate;
	}

	public short getExp() {
		return exp;
	}

	public void setExp(short exp) {
		this.exp = exp;
	}

	public short[] getStartingMoves() {
		return startingMoves;
	}

	public void setStartingMoves(short[] startingMoves) {
		this.startingMoves = startingMoves;
	}

	public short[] getPossibleMoves() {
		return possibleMoves;
	}

	public void setPossibleMoves(short[] possibleMoves) {
		this.possibleMoves = possibleMoves;
	}

	public short[] getMoveLevels() {
		return moveLevels;
	}

	public void setMoveLevels(short[] moveLevels) {
		this.moveLevels = moveLevels;
	}

	public short[] getEvolvesInto() {
		return evolvesInto;
	}

	public void setEvolvesInto(short[] evolvesInto) {
		this.evolvesInto = evolvesInto;
	}

	public short[] getEvolveLevels() {
		return evolveLevels;
	}

	public void setEvolveLevels(short[] evolveLevels) {
		this.evolveLevels = evolveLevels;
	}

}
