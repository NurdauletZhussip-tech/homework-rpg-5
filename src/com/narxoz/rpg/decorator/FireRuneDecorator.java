package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        // TODO: Decide how this decorator changes the visible action name.
        return super.getActionName()+"with fire";
    }

    @Override
    public int getDamage() {
        // TODO: Add fire-related behavior on top of wrapped damage.
        return super.getDamage()+30;
    }

    @Override
    public String getEffectSummary() {
        // TODO: Append or compose the fire effect description.
        return super.getEffectSummary()+"burns for 23 seconds";
    }
}
