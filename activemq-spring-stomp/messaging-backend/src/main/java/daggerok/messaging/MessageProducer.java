package daggerok.messaging;

import daggerok.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProducer {

  final JmsTemplate jmsTemplate;

  public void send(final Message message) {
    log.debug("before save {}", message);
    jmsTemplate.convertAndSend("jms.topic.messages", message);
  }
}
