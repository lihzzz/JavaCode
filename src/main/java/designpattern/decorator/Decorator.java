package designpattern.decorator;

/**
 * @author liuhuan <liuhuan07@kuaishou.com>
 * Created on 2020/11/9
 */
public class Decorator extends Component{
    protected Component component;

    public void SetComponent(Component component){
        this.component = component;
    }

    @Override
    public void Operation() {
        if(this.component != null){
            this.component.Operation();
        }
    }
}
