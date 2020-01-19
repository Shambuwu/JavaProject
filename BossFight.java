public class BossFight{
    public BossFight(Player player, EnemyStats enemyStats){
        Enemy boss = new Enemy(enemyStats);
        Encounter bossFight = new Encounter(player, boss);
    }
}